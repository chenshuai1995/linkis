/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.cs.persistence;

import com.webank.wedatasphere.linkis.cs.persistence.persistence.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ContextPersistenceBeans {

    @Bean
    @ConditionalOnMissingBean(ContextPersistenceManager.class)
    public ContextPersistenceManager getContextPersistenceManager(
            ContextIDPersistence contextIDPersistence,
            ContextMapPersistence contextMapPersistence,
            ContextHistoryPersistence contextHistoryPersistence,
            ContextMetricsPersistence contextMetricsPersistence,
            ContextIDListenerPersistence contextIDListenerPersistence,
            ContextKeyListenerPersistence contextKeyListenerPersistence,
            TransactionManager transactionManager,
            KeywordContextHistoryPersistence keywordContextHistoryPersistence
    ) {
        ContextPersistenceManagerImpl manager = new ContextPersistenceManagerImpl();
        manager.setContextIDPersistence(contextIDPersistence);
        manager.setContextMapPersistence(contextMapPersistence);
        manager.setContextHistoryPersistence(contextHistoryPersistence);
        manager.setContextMetricsPersistence(contextMetricsPersistence);
        manager.setContextKeyListenerPersistence(contextKeyListenerPersistence);
        manager.setContextIDListenerPersistence(contextIDListenerPersistence);
        manager.setTransactionManager(transactionManager);
        manager.setKeywordContextHistoryPersistence(keywordContextHistoryPersistence);
        return manager;
    }
}