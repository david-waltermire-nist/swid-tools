/**
 * Portions of this software was developed by employees of the National Institute
 * of Standards and Technology (NIST), an agency of the Federal Government and is
 * being made available as a public service. Pursuant to title 17 United States
 * Code Section 105, works of NIST employees are not subject to copyright
 * protection in the United States. This software may be subject to foreign
 * copyright. Permission in the United States and in foreign countries, to the
 * extent that NIST may hold copyright, to use, copy, modify, create derivative
 * works, and distribute this software and its documentation without fee is hereby
 * granted on a non-exclusive basis, provided that this notice and disclaimer
 * of warranty appears in all copies.
 *
 * THE SOFTWARE IS PROVIDED 'AS IS' WITHOUT ANY WARRANTY OF ANY KIND, EITHER
 * EXPRESSED, IMPLIED, OR STATUTORY, INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY
 * THAT THE SOFTWARE WILL CONFORM TO SPECIFICATIONS, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND FREEDOM FROM
 * INFRINGEMENT, AND ANY WARRANTY THAT THE DOCUMENTATION WILL CONFORM TO THE
 * SOFTWARE, OR ANY WARRANTY THAT THE SOFTWARE WILL BE ERROR FREE.  IN NO EVENT
 * SHALL NIST BE LIABLE FOR ANY DAMAGES, INCLUDING, BUT NOT LIMITED TO, DIRECT,
 * INDIRECT, SPECIAL OR CONSEQUENTIAL DAMAGES, ARISING OUT OF, RESULTING FROM,
 * OR IN ANY WAY CONNECTED WITH THIS SOFTWARE, WHETHER OR NOT BASED UPON WARRANTY,
 * CONTRACT, TORT, OR OTHERWISE, WHETHER OR NOT INJURY WAS SUSTAINED BY PERSONS OR
 * PROPERTY OR OTHERWISE, AND WHETHER OR NOT LOSS WAS SUSTAINED FROM, OR AROSE OUT
 * OF THE RESULTS OF, OR USE OF, THE SOFTWARE OR SERVICES PROVIDED HEREUNDER.
 */

package gov.nist.secauto.swid.builder.resource.firmware;

import gov.nist.secauto.swid.builder.util.Util;

import java.util.Objects;

public class DeviceIdentifier {
  private final String vendor;
  private String type;
  private final String model;
  private String clazz;
  private String rfc4122;
  private byte[] ieee8021ar;

  /**
   * Construct a new device identifier.
   * 
   * @param vendor
   *          the device vendor string
   * @param model
   *          the device model string
   */
  public DeviceIdentifier(String vendor, String model) {
    super();
    Util.requireNonEmpty(vendor, "vendor");
    Util.requireNonEmpty(vendor, "model");
    this.vendor = vendor;
    this.model = model;
  }

  /**
   * Retrieve the vendor string.
   * 
   * @return the vendor
   */
  public String getVendor() {
    return vendor;
  }

  /**
   * Retrieve the type string.
   * 
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Set the type.
   * 
   * @param type
   *          the type to set
   */
  public void setType(String type) {
    Util.requireNonEmpty(type);
    this.type = type;
  }

  /**
   * Retrieve the model string.
   * 
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Retrieve the class string.
   * 
   * @return the clazz
   */
  public String getClazz() {
    return clazz;
  }

  /**
   * Set the class string.
   * 
   * @param clazz
   *          the clazz to set
   */
  public void setClazz(String clazz) {
    Util.requireNonEmpty(clazz);
    this.clazz = clazz;
  }

  /**
   * @return the rfc4122
   */
  public String getRfc4122() {
    return rfc4122;
  }

  /**
   * @param rfc4122
   *          the rfc4122 to set
   */
  public void setRfc4122(String rfc4122) {
    Util.requireNonEmpty(rfc4122);
    this.rfc4122 = rfc4122;
  }

  /**
   * @return the ieee8021ar
   */
  public byte[] getIeee8021ar() {
    return ieee8021ar;
  }

  /**
   * @param ieee8021ar
   *          the ieee8021ar to set
   */
  public void setIeee8021ar(byte[] ieee8021ar) {
    Objects.requireNonNull(ieee8021ar, "ieee8021ar");
    this.ieee8021ar = ieee8021ar;
  }

}
