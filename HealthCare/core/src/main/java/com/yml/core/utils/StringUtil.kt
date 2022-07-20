package com.yml.core.utils

fun String?.isPresent(): Boolean {
    return this != null && this.isNotBlank()
}