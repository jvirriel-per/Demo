package com.jvirriel.demo.frontend.components.custom.tagsfield;

import java.util.ArrayList;
import java.util.List;

import com.jvirriel.demo.frontend.components.custom.fieldadder.CustomFieldAdder;
import com.jvirriel.demo.frontend.components.custom.fieldadder.EmailFieldAdder;
import com.vaadin.ui.Button;

public class EmailTagsField extends AbstractTagsField {

    public EmailTagsField() {
        super("Email");

        CustomFieldAdder fieldAdder = new EmailFieldAdder();

        formDialog.setDialogContent(fieldAdder);

        formDialog.setAcceptListener((Button.ClickListener) ev -> {
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
    public void updateModalDialog() {
        CustomFieldAdder dialogCurrentContent = (CustomFieldAdder) formDialog.getDialogContent();
        List<Tag> currentTagSet = getTags();
        List<List<String>> newTagSet = new ArrayList<>();

        if (!currentTagSet.isEmpty()) {
            for (Tag tag : currentTagSet) {
                List<String> newEmailTag = new ArrayList<>();
                newEmailTag.add(tag.getValue());
                newTagSet.add(newEmailTag);
            }

            dialogCurrentContent.setValues(newTagSet);
        }
    }
}
