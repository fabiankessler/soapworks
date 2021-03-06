package com.optimaize.anythingworks.server.rest;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 */
public interface RestWebServiceProvider {
    @NotNull
    List<RestWebService> getAll();
}
