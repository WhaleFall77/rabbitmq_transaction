package com.itmuch.cloud.study.annotation;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//如果嫌在@RabbitListener中参数太多，可以写元注解MyAnonFanoutListener，以用于增强@RabbitListener注解
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RabbitListener(bindings = @QueueBinding(
    value = @Queue,
    exchange = @Exchange(type = ExchangeTypes.FANOUT)))
public @interface MyAnonFanoutListener {

    @AliasFor(annotation = Exchange.class, attribute = "value")
    String exchangeValue() default "";
}