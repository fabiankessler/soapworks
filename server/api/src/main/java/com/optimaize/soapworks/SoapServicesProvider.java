package com.optimaize.soapworks;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This service provides soap services that can then be published.
 */
public interface SoapServicesProvider {

    /**
     * All the services to publish.
     */
    @NotNull
    List<SoapWebService> getAll();

}
