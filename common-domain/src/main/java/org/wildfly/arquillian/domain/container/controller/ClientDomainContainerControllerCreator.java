/*
 * Copyright 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wildfly.arquillian.domain.container.controller;


import org.jboss.arquillian.container.spi.event.SetupContainers;
import org.jboss.arquillian.core.api.Injector;
import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.InstanceProducer;
import org.jboss.arquillian.core.api.annotation.ApplicationScoped;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.wildfly.arquillian.domain.api.DomainContainerController;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class ClientDomainContainerControllerCreator {

    @Inject
    @ApplicationScoped
    private InstanceProducer<DomainContainerController> controller;

    @Inject
    private Instance<Injector> injector;

    @SuppressWarnings("UnusedParameters")
    public void create(@Observes SetupContainers event) {
        controller.set(injector.get().inject(new ClientDomainContainerController()));
    }
}

