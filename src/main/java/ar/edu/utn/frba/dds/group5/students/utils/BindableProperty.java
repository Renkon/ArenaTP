package ar.edu.utn.frba.dds.group5.students.utils;

import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BindableProperty{

    protected String friendlyName;
    protected String classField;
    protected String description;
    protected Class<?> controlClass;

    public BindableProperty(String friendlyName, String classField, String description, Class<?> controlClass) {
        this.friendlyName = friendlyName;
        this.classField = classField;
        this.description = description;
        this.controlClass = controlClass;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getClassField() {
        return classField;
    }

    public String getDescription() {
        return description;
    }

    public Class getControlClass() {
        return controlClass;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setControlClass(Class controlClass) {
        this.controlClass = controlClass;
    }

    public void addAndBindToPanel(Panel panel) {
        try {
            new Label(panel).setText(this.getDescription()).setWidth(600);
            ((Control) this.getControlClass().getDeclaredConstructor(Panel.class).newInstance(panel)).bindValueToProperty(this.getClassField());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void addAndBindToPanelWithTable(Panel panel, Table table) {
        new Column(table).setFixedSize(200).setTitle(this.getFriendlyName()).
                bindContentsToProperty(this.getClassField());

        addAndBindToPanel(panel);
    }
}
