package com.vue.core.models;

import java.util.List;
import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Home extends ComponentExporter {
    List<Items> getItems();
}