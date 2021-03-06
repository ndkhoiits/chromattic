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

package org.chromattic.test.property.value.multi.array;

import org.chromattic.api.annotations.DefaultValue;
import org.chromattic.api.annotations.PrimaryType;
import org.chromattic.api.annotations.Property;

import java.util.Date;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
@PrimaryType(name = "property_array:c")
public abstract class C {

  @Property(name = "string_array_property")
  @DefaultValue
  public abstract String[] getStringArrayProperty();

  public abstract void setStringArrayProperty(String[] s);

  @Property(name = "primitive_int_array_property")
  @DefaultValue
  public abstract int[] getIntArrayProperty();

  public abstract void setIntArrayProperty(int[] s);

  @Property(name = "int_array_property")
  @DefaultValue
  public abstract Integer[] getIntegerArrayProperty();

  public abstract void setIntegerArrayProperty(Integer[] s);

  @Property(name = "primitive_long_array_property")
  @DefaultValue
  public abstract long[] getPrimitiveLongArrayProperty();

  public abstract void setPrimitiveLongArrayProperty(long[] s);

  @Property(name = "long_array_property")
  @DefaultValue
  public abstract Long[] getLongArrayProperty();

  public abstract void setLongArrayProperty(Long[] s);

  @Property(name = "primitive_boolean_array_property")
  @DefaultValue
  public abstract boolean[] getPrimitiveBooleanArrayProperty();

  public abstract void setPrimitiveBooleanArrayProperty(boolean[] s);

  @Property(name = "primitive_boolean_array_property")
  public abstract boolean[] getNullablePrimitiveBooleanArrayProperty();

  public abstract void setNullablePrimitiveBooleanArrayProperty(boolean[] s);

  @Property(name = "boolean_array_property")
  @DefaultValue
  public abstract Boolean[] getBooleanArrayProperty();

  public abstract void setBooleanArrayProperty(Boolean[] s);

  @Property(name = "date_array_property")
  @DefaultValue
  public abstract Date[] getDateArrayProperty();

  public abstract void sewtDateArrayProperty(Date[] s);

}