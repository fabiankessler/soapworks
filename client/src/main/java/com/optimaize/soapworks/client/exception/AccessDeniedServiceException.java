package com.optimaize.soapworks.client.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Thrown when the server denies access to the client.
 *
 * <p>Possible causes:
 * <ul>
 *   <li>invalid credentials</li>
 *   <li>account inactive, disabled, deleted</li>
 *   <li>out of credits</li>
 * </ul></p>
 *
 * @author fab
 */
public class AccessDeniedServiceException extends ServiceException {

    public AccessDeniedServiceException(String message, @NotNull FaultInfo faultInfo) {
        super(message, faultInfo);
    }

}
