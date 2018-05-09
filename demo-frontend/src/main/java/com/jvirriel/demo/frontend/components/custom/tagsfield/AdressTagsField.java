package com.jvirriel.demo.frontend.components.custom.tagsfield;

import com.jvirriel.demo.frontend.components.custom.fieldadder.AdressFieldAdder;
import com.jvirriel.demo.frontend.components.custom.fieldadder.CustomFieldAdder;

import java.util.ArrayList;
import java.util.List;

public class AdressTagsField extends AbstractTagsField {

    public AdressTagsField(String caption) {
        super(caption);

        CustomFieldAdder fieldAdder = new AdressFieldAdder();

        formDialog.setDialogContent(fieldAdder);

        formDialog.setAcceptListener(event -> {
            CustomFieldAdder fa = (CustomFieldAdder) formDialog.getDialogContent();
            List<List<String>> dialogCurrentValues = fa.getValues();
            List<Tag> tags = new ArrayList<>();

            for (List<String> value : dialogCurrentValues) {
                if (!value.get(0).isEmpty()) {
                    String data = value.get(0)+", "+value.get(1)+", "+value.get(2);
                    ClosableTagFieldItem newTag = new ClosableTagFieldItem(data);
                    newTag.setRemoveTagListener(clickEvent -> removeTag(newTag));
                    tags.add(newTag);
                }
            }
            setTags(tags);
            formDialog.getWindow().close();
        });
    }

    @Override
    void updateModalDialog() {

    }
}
