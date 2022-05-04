package com.vue.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.vue.core.models.Notfound;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.apache.sling.models.factory.ModelFactory;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Notfound.class, ComponentExporter.class},
        resourceType = {NotfoundImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class NotfoundImpl implements Notfound {

    protected static final String RESOURCE_TYPE = "vue/components/not-found";

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String upperText;

    @ValueMapValue
    private String middleText;

    @ValueMapValue
    private String buttonText;

    @ValueMapValue
    private String buttonLink;

    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public String getUpperText() {
        return upperText;
    }

    @Override
    public String getMiddleText() {
        return middleText;
    }

    @Override
    public String getButtonText() {
        return buttonText;
    }

    @Override
    public String getButtonLink() {
        return buttonLink;
    }

    @Override
    public String getExportedType() {
        return NotfoundImpl.RESOURCE_TYPE;
    }
    
}
