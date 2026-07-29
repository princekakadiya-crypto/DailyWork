package com.tss.core.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.tss.core.entity")
public class AutoConfig {
}
