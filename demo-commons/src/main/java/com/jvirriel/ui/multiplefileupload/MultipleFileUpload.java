package com.jvirriel.ui.multiplefileupload;

import com.jvirriel.xml.deliveryorder.common.Attachment;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MultipleFileUpload extends VerticalLayout {
    private List<String> itemsAdded = new ArrayList<>();
    private List<File> itemsFile = new ArrayList<>();
    private Button uploadAllBtn;
    private VerticalLayout itemsAddedContainer;

    public MultipleFileUpload(String url) {
        super.setMargin(false);
   /*     super.setWidth("100%");*/

        itemsAddedContainer = new VerticalLayout();
        itemsAddedContainer.setMargin(false);
        buildUpload(url);
    }

    private void buildUpload(String url) {
        class ImageReceiver implements Upload.Receiver, Upload.SucceededListener {
            public File file;
            public FileResource fileResource;

            public OutputStream receiveUpload(String filename, String mimeType) {
                FileOutputStream fos;
                try {
                    file = new File(filename);
                    fos = new FileOutputStream(file);
                } catch (final java.io.FileNotFoundException e) {
                    new Notification("No se pudo abrir el archivo", e.getMessage(),
                            Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
                    return null;
                }
                return fos;
            }

            public void uploadSucceeded(Upload.SucceededEvent event) {
                fileResource = new FileResource(file);
            }
        }

        ImageReceiver receiver = new ImageReceiver();

        final Upload upload = new Upload("Seleccionar archivo", receiver);
        upload.setButtonCaption("Adjuntar archivos");

        upload.addSucceededListener(receiver);

        final long UPLOAD_LIMIT = 1000000l;
        upload.addStartedListener(event -> {
            if (event.getContentLength() > UPLOAD_LIMIT) {
                Notification.show("Archivo muy grande", Notification.Type.ERROR_MESSAGE);
                upload.interruptUpload();
            }
        });

        upload.addProgressListener((Upload.ProgressListener) (readBytes, contentLength) -> {
            if (readBytes > UPLOAD_LIMIT) {
                Notification.show("Archivo muy grande",
                        Notification.Type.ERROR_MESSAGE);
                upload.interruptUpload();
            }
        });

        upload.addSucceededListener(event -> Notification.show("Archivo agregado"));

        Label panelName = new Label("Archivos agregados para subir");
        panelName.addStyleName(ValoTheme.LABEL_BOLD);
        panelName.addStyleName(ValoTheme.LABEL_H3);

        itemsAddedContainer.addComponent(panelName);

        this.itemsAdded = new ArrayList<>();
        this.itemsFile = new ArrayList<>();

        upload.addFinishedListener(event -> {
            upload.setVisible(true);
            upload.setCaption("Seleccionar otro archivo");

            File file = new File(receiver.file.getPath());

            file.renameTo(new File(url + receiver.file.getName()));

            List<String> temporalItem = new ArrayList<>();
            temporalItem.add(" Nombre: " + receiver.file.getName() + "\n" + " Ruta final: "+url + "\n"
                    + " Extensión: " + receiver.fileResource.getMIMEType());

            this.itemsFile.add(file);
            this.itemsAdded.add(temporalItem.get(0));
            buildItemsContainer(this.itemsAdded);
        });

        super.addComponent(upload);
        super.addComponents(itemsAddedContainer);
    }

    public List<String> getItemsAdded(){
        return this.itemsAdded;
    }

    public List<com.jvirriel.xml.deliveryorder.common.File> getItemsFile(){
        List<com.jvirriel.xml.deliveryorder.common.File> fileList = new ArrayList<>();
        com.jvirriel.xml.deliveryorder.common.File file;

        for (File anItemsFile : itemsFile) {
            file = new com.jvirriel.xml.deliveryorder.common.File();
            file.setPath(anItemsFile.getPath());
            fileList.add(file);
        }

        return fileList;
    }

    private void buildItemsContainer(List<String> itemsAdded) {
        if (itemsAdded.size() > 1) {
            itemsAddedContainer.removeAllComponents();
        }
        for (int i = 0; i < itemsAdded.size(); i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.setMargin(false);

            Label label = new Label(itemsAdded.get(i));
            Button removeBtn = new Button(VaadinIcons.FILE_REMOVE);
            removeBtn.addStyleName(ValoTheme.BUTTON_BORDERLESS);

            int finalI = i;
            removeBtn.addClickListener(event -> {
                itemsAddedContainer.removeComponent(horizontalLayout);
                itemsAdded.remove(finalI);
            });
            this.itemsAdded = itemsAdded;
            horizontalLayout.addComponents(label, removeBtn);
            itemsAddedContainer.addComponents(horizontalLayout);
        }
    }

    private void buildUploadAllButton() {
        uploadAllBtn = new Button("Subir archivos", VaadinIcons.UPLOAD);
        uploadAllBtn.addClickListener(event -> {
        });
        super.addComponents(itemsAddedContainer, uploadAllBtn);
    }

}