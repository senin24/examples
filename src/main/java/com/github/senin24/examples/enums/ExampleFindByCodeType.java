package com.github.senin24.examples.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ExampleFindByCodeType {

  SUCCESS(0L, "SUCCESS"),
  ERROR(1L, "ERROR"),
  ANY(2L, "ANY");

  private Long flagId;
  private String description;

  public static ExampleFindByCodeType findByCode(String code) {
    if (Objects.isNull(code)) {
      throw new IllegalArgumentException("Value not be null");
    }
    int flagIdIntValue;
    try {
      flagIdIntValue = Integer.valueOf(code);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Value must be integer number, but now is " + code);
    }
    for (ExampleFindByCodeType type : ExampleFindByCodeType.values()) {
      if (type.flagId.intValue() == flagIdIntValue) {
        return type;
      }
    }
    throw new IllegalArgumentException("Value must be , '0', '1' or '2', but now is " + code);
  }

  public static ExampleFindByCodeType findByCodeByStream(String code) {
    if (Objects.isNull(code)) {
      throw new IllegalArgumentException("Value not be null");
    }
    int flagIdIntValue;
    try {
      flagIdIntValue = Integer.valueOf(code);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Value must be integer number, but now is " + code);
    }
    return Arrays.stream(ExampleFindByCodeType.values())
        .filter(e -> e.flagId.intValue() == flagIdIntValue)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Value must be , '0', '1' or '2', but now is " + code));
  }
}
