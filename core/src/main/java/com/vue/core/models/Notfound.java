package com.vue.core.models;

import com.adobe.cq.wcm.core.components.models.Image;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Notfound extends Image {

    Image getImage();

    String getUpperText();

    String getMiddleText();

    String getButtonText();

    String getButtonLink();

}
