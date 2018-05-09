package com.jvirriel.xmlengine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class XmlEngine<T> {
    private static final String XML_HEADER_METADATA = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
    private static final String LIST = "list";

    private static Function<String, StringReader> readerBuilder = StringReader::new;
    private static Supplier<StringWriter> writerBuilder = StringWriter::new;

    private Class<T> objectClass;

    public static <T> String convertObjectToXml(T object, Class... objectClass) {
        try {
            StringWriter writer = writerBuilder.get();

            JAXBContext context = JAXBContext.newInstance(objectClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(object, writer);

            return getReplace(writer);
        } catch (JAXBException expception) {
            expception.printStackTrace();

            return null;
        }
    }

    public static <T> String convertObjectListToXml(List<T> objectList, Class<T> objectClass) {
        try {
            StringWriter writer = writerBuilder.get();

            JAXBContext context = JAXBContext.newInstance(ElementList.class, objectClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ElementList<T> elementList = new ElementList<>();
            elementList.setList(objectList);

            marshaller.marshal(elementList, writer);

            return getReplace(writer);
        } catch (JAXBException exception) {
            exception.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T convertXmlToObject(String xml, Class... objectClass) {
        try {
            StringReader reader = readerBuilder.apply(xml);

            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException exception) {
            exception.printStackTrace();

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> convertXmlToObjectList(String xml, Class<T> objectClass) {
        try {
            StringReader reader = readerBuilder.apply(xml);

            JAXBContext context = JAXBContext.newInstance(ElementList.class, objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ElementList<T> elmentList = (ElementList<T>) unmarshaller.unmarshal(reader);

            return elmentList.getList();
        } catch (JAXBException exception) {
            exception.printStackTrace();

            return null;
        }
    }

    private static String getReplace(StringWriter writer) {
        return writer
                .toString()
                .replace(XML_HEADER_METADATA, EMPTY);
    }

    @XmlRootElement(name = LIST)
    private static class ElementList<T> {
        private List<T> list;

        public ElementList() {
            this.list = new ArrayList<T>();
        }

        @XmlAnyElement(lax = true)
        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }
    }
}
