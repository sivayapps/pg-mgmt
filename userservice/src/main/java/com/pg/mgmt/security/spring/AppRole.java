/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pg.mgmt.security.spring;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Siva on 4/9/2017.
 */
public enum AppRole implements GrantedAuthority {
	ADMIN(0), NEW_USER(1), USER(2), PG_ADMIN(3), PG_CUSTOMER(4), ANONYMOUS(5);

	private final int bit;

	/**
	 * Creates an authority with a specific bit representation. It's important that this
	 * doesn't change as it will be used in the database. The enum ordinal is less
	 * reliable as the enum may be reordered or have new roles inserted which would change
	 * the ordinal values.
	 *
	 * @param bit the permission bit which will represent this authority in the datastore.
	 */
	AppRole(int bit) {
		this.bit = bit;
	}

	public int getBit() {
		return bit;
	}

	public String getAuthority() {
		return "ROLE_"+toString();
	}
}
