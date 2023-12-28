#include <stdio.h>
#include <stddef.h>
#include <memory.h>

#include "/Volumes/Elements/Library/graalvm-jdk-21.0.1+12.1/Contents/Home/lib/svm/clibraries/darwin-aarch64/include/aarch64cpufeatures.h"

int AArch64LibCHelperDirectives() {
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(CPUFeatures)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fA53MAC)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fA53MAC)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fA53MAC = all_bits_set;
        is_unsigned = fieldHolder.fA53MAC > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fA53MAC:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fAES)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fAES)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fAES = all_bits_set;
        is_unsigned = fieldHolder.fAES > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fAES:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fASIMD)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fASIMD)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fASIMD = all_bits_set;
        is_unsigned = fieldHolder.fASIMD > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fASIMD:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fCRC32)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fCRC32)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fCRC32 = all_bits_set;
        is_unsigned = fieldHolder.fCRC32 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fCRC32:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fDCPOP)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fDCPOP)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fDCPOP = all_bits_set;
        is_unsigned = fieldHolder.fDCPOP > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDCPOP:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMB_ATOMICS:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fDMB_ATOMICS)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMB_ATOMICS:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fDMB_ATOMICS)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fDMB_ATOMICS = all_bits_set;
        is_unsigned = fieldHolder.fDMB_ATOMICS > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fDMB_ATOMICS:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fEVTSTRM)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fEVTSTRM)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fEVTSTRM = all_bits_set;
        is_unsigned = fieldHolder.fEVTSTRM > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fEVTSTRM:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fFP)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fFP)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fFP = all_bits_set;
        is_unsigned = fieldHolder.fFP > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fFP:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fLSE)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fLSE)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fLSE = all_bits_set;
        is_unsigned = fieldHolder.fLSE > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fLSE:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPACA:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fPACA)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPACA:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fPACA)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fPACA = all_bits_set;
        is_unsigned = fieldHolder.fPACA > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPACA:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fPMULL)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fPMULL)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fPMULL = all_bits_set;
        is_unsigned = fieldHolder.fPMULL > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fPMULL:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSHA1)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSHA1)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA1 = all_bits_set;
        is_unsigned = fieldHolder.fSHA1 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA1:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSHA2)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSHA2)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA2 = all_bits_set;
        is_unsigned = fieldHolder.fSHA2 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSHA3)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSHA3)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA3 = all_bits_set;
        is_unsigned = fieldHolder.fSHA3 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA3:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSHA512)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSHA512)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSHA512 = all_bits_set;
        is_unsigned = fieldHolder.fSHA512 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSHA512:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXR_PREFETCH:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSTXR_PREFETCH)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXR_PREFETCH:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSTXR_PREFETCH)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSTXR_PREFETCH = all_bits_set;
        is_unsigned = fieldHolder.fSTXR_PREFETCH > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSTXR_PREFETCH:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSVE)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSVE)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSVE = all_bits_set;
        is_unsigned = fieldHolder.fSVE > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSVE2)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSVE2)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSVE2 = all_bits_set;
        is_unsigned = fieldHolder.fSVE2 > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVE2:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVEBITPERM:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((CPUFeatures *) 0)->fSVEBITPERM)));
    printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVEBITPERM:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(CPUFeatures, fSVEBITPERM)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        CPUFeatures fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.fSVEBITPERM = all_bits_set;
        is_unsigned = fieldHolder.fSVEBITPERM > 0;
        printf("NativeCodeInfo:AArch64LibCHelperDirectives:StructInfo:CPUFeatures:StructFieldInfo:fSVEBITPERM:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    return 0;
}

int main(void) {
    return AArch64LibCHelperDirectives();
}
