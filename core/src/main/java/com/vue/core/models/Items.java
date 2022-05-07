package com.vue.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.osgi.annotation.versioning.ConsumerType;


@ConsumerType
public interface Items extends ComponentExporter {
    @JsonProperty("en")
    String getEn();

    @JsonProperty("pt")
    String getPt();
}