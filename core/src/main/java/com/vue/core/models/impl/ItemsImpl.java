package com.vue.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vue.core.models.Items;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = { SlingHttpServletRequest.class },
    adapters = { Items.class, ComponentExporter.class }
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ItemsImpl implements Items
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String en;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String pt;

    @SlingObject
    private Resource resource;

    @Override
    @JsonProperty("en")
    public String getEn() {
        return en;
    }

    @Override
    @JsonProperty("pt")
    public String getPt() {
        return pt;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}