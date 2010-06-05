/*
 * Copyright (C) 2003-2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.chromattic.metamodel.type;

import org.chromattic.metamodel.mapping.jcr.JCRPropertyType;
import org.chromattic.spi.type.SimpleTypeProvider;
import org.reflext.api.ClassTypeInfo;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
class ValueTypeInfoImpl<I> implements ValueTypeInfo {

  /** . */
  private SimpleTypeProvider<I, ?> instance;

  /** . */
  private final JCRPropertyType<I> propertyType;

  /** . */
  private final ClassTypeInfo typeInfo;

  ValueTypeInfoImpl(ClassTypeInfo typeInfo, JCRPropertyType<I> propertyType) {
    this.propertyType = propertyType;
    this.typeInfo = typeInfo;
  }

  ValueTypeInfoImpl(Class<? extends SimpleTypeProvider<I, ?>> type, JCRPropertyType<I> propertyType) {
    this.propertyType = propertyType;
    this.typeInfo = (ClassTypeInfo)PropertyTypeResolver.typeDomain.resolve(type);
  }

  public JCRPropertyType<I> getJCRPropertyType() {
    return propertyType;
  }

  public SimpleTypeProvider<I, ?> create() {
    if (instance == null) {
      Class type = (Class)typeInfo.getType();
      try {
        instance = (SimpleTypeProvider<I,?>)type.newInstance();
      }
      catch (InstantiationException e) {
        throw new AssertionError(e);
      }
      catch (IllegalAccessException e) {
        throw new AssertionError(e);
      }
    }
    return instance;
  }
}