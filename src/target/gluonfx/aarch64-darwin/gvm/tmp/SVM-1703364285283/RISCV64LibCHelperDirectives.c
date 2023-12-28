#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include "/Volumes/Elements/Library/graalvm-jdk-21.0.1+12.1/Contents/Home/lib/svm/clibraries/darwin-aarch64/include/riscv64cpufeatures.h"

int RISCV64LibCHelperDirectives() {
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(CPUFeatures)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fA)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fA)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fA = all_bits_set;
        is_unsigned = fieldHolder.fA > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fC:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fC)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fC:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fC)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fC = all_bits_set;
        is_unsigned = fieldHolder.fC > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fC:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fD:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fD)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fD:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fD)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fD = all_bits_set;
        is_unsigned = fieldHolder.fD > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fD:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fF:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fF)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fF:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fF)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fF = all_bits_set;
        is_unsigned = fieldHolder.fF > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fF:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fI:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fI)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fI:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fI)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fI = all_bits_set;
        is_unsigned = fieldHolder.fI > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fI:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fM:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fM)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fM:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fM)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fM = all_bits_set;
        is_unsigned = fieldHolder.fM > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fM:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fV:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fV)));
    printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fV:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fV)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fV = all_bits_set;
        is_unsigned = fieldHolder.fV > 0;
        printf("NativeCodeInfo:RISCV64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fV:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    return 0;
}

int main(void) {
    return RISCV64LibCHelperDirectives();
}
