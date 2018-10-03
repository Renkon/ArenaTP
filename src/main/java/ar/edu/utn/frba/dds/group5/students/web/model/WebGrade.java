package ar.edu.utn.frba.dds.group5.students.web.model;

import com.google.api.client.util.Key;
import org.eclipse.swt.widgets.DateTime;

public abstract class WebGrade {
    @Key("id") private long id;
    @Key("created_at") private DateTime createdAt;
    @Key("updated_at") private DateTime updatedAt;

    public long getId() {
        return id;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }
}
