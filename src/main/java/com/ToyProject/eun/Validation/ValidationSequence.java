package com.ToyProject.eun.Validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ValidationGroup.NotBlankGroup.class, ValidationGroup.SizeGroup.class, ValidationGroup.PatternCheckGroup.class, Default.class})
public interface ValidationSequence {
}
