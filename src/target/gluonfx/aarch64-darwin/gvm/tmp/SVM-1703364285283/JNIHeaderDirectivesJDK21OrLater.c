#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include "/Volumes/Elements/Library/graalvm-jdk-21.0.1+12.1/Contents/Home/include/jni.h"

int JNIHeaderDirectivesJDK21OrLater() {
    printf("NativeCodeInfo:JNIHeaderDirectivesJDK21OrLater:ConstantInfo:JNI_VERSION_21:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(JNI_VERSION_21)));
    printf("NativeCodeInfo:JNIHeaderDirectivesJDK21OrLater:ConstantInfo:JNI_VERSION_21:PropertyInfo:signedness=$%s$\n", ((JNI_VERSION_21>=0 ? 1 : 0)) ? "UNSIGNED" : "SIGNED");
    printf("NativeCodeInfo:JNIHeaderDirectivesJDK21OrLater:ConstantInfo:JNI_VERSION_21:PropertyInfo:value=%lX\n", ((unsigned long)JNI_VERSION_21));
    return 0;
}

int main(void) {
    return JNIHeaderDirectivesJDK21OrLater();
}
