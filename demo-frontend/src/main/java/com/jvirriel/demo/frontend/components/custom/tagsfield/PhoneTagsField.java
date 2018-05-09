package com.jvirriel.demo.frontend.components.custom.tagsfield;

import com.jvirriel.demo.frontend.components.custom.fieldadder.CustomFieldAdder;
import com.jvirriel.demo.frontend.components.custom.fieldadder.PhoneFieldAdder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Notification;

import java.util.ArrayList;
import java.util.List;

public class PhoneTagsField extends AbstractTagsField {
    public PhoneTagsField(String caption) {
        super(caption);

        CustomFieldAdder fieldAdder = new PhoneFieldAdder();

        formDialog.setDialogContent(fieldAdder);

        formDialog.setAcceptListener(event -> {
            CustomFieldAdder fa = (CustomFieldAdder) formDialog.getDialogContent();
            List<List<String>> dialogCurrentValues = fa.getValues();
            List<Tag> tags = new ArrayList<>();

            for (List<String> value : dialogCurrentValues) {
                if (!value.get(0).isEmpty()) {

                    ClosableTagFieldItem newTag = new ClosableTagFieldItem(value.get(0));
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
        CustomFieldAdder dialogCurrentContent = (CustomFieldAdder) formDialog.getDialogContent();
        List<Tag> currentTagSet = getTags();
        List<List<String>> newTagSet = new ArrayList<>();

        if (!currentTagSet.isEmpty()) {
            for (Tag tag : currentTagSet) {
                List<String> newPhoneTag = new ArrayList<>();
                newPhoneTag.add(tag.getValue());
                newTagSet.add(newPhoneTag);
            }

            dialogCurrentContent.setValues(newTagSet);
        }
    }
}
