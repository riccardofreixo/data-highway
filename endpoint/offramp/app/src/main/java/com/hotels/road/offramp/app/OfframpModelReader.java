/**
 * Copyright (C) 2016-2019 Expedia Inc.
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
package com.hotels.road.offramp.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.hotels.road.agents.trafficcop.spi.ModelReader;
import com.hotels.road.model.core.Road;

/**
 * <pre>
 * {
 *   "topicName": "name",
 *   "schemas": {
 *     "1": {
 *       "schema": {...}
 *     }
 *   }
 * }
 * </pre>
 */
@Component
class OfframpModelReader implements ModelReader<Road> {
  private final ObjectMapper mapper;

  OfframpModelReader(@Value("#{jsonMapper}") ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public Road read(JsonNode json) {
    return mapper.convertValue(json, Road.class);
  }
}
