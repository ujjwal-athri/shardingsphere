/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.integration.framework.compose;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.shardingsphere.test.integration.framework.container.ShardingSphereContainers;
import org.apache.shardingsphere.test.integration.framework.container.adapter.AdapterContainer;
import org.apache.shardingsphere.test.integration.framework.container.storage.StorageContainer;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Composed container.
 */
public abstract class ComposedContainer {
    
    @Getter(AccessLevel.PROTECTED)
    private final ShardingSphereContainers containers;
    
    public ComposedContainer(final String testSuiteName) {
        containers = new ShardingSphereContainers(testSuiteName);
    }
    
    /**
     * Get adapter container.
     *
     * @return adapter container
     */
    public abstract AdapterContainer getAdapterContainer();
    
    /**
     * Get storage container.
     *
     * @return storage container
     */
    public abstract StorageContainer getStorageContainer();
    
    /**
     * Get all target data sources.
     *
     * @return datasource map
     */
    public abstract Map<String, DataSource> getDataSourceMap();
}