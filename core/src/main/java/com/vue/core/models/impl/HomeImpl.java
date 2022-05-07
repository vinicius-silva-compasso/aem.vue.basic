package com.vue.core.models.impl;

import java.util.Collections;
import java.util.List;

import com.adobe.acs.commons.models.injectors.annotation.ChildResourceFromRequest;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.vue.core.models.Home;
import com.vue.core.models.Items;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(
    adaptables = { SlingHttpServletRequest.class },
     adapters = { Home.class, ComponentExporter.class },
     resourceType = HomeImpl.RESOURCE_TYPE
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HomeImpl implements Home {
    protected static final String RESOURCE_TYPE = "vue/components/home";

    @ChildResourceFromRequest(injectionStrategy = InjectionStrategy.OPTIONAL)
    private List<Items> items;
    
    @SlingObject
    private Resource resource;

    @Override
    public List<Items> getItems() {
        return items != null ? Collections.unmodifiableList(items) : null;
    }

    @Override
    public String getExportedType() {
        return HomeImpl.RESOURCE_TYPE;
    }
}