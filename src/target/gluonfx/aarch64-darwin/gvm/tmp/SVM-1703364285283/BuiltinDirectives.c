#include <stdio.h>
#include <stddef.h>
#include <memory.h>

/*
 * Structure representing an isolate. A pointer to such a structure can be
 * passed to an entry point as the execution context.
 */
struct __graal_isolate_t;
typedef struct __graal_isolate_t graal_isolate_t;

/*
 * Structure representing a thread that is attached to an isolate. A pointer to
 * such a structure can be passed to an entry point as the execution context,
 * requiring that the calling thread has been attached to that isolate.
 */
struct __graal_isolatethread_t;
typedef struct __graal_isolatethread_t graal_isolatethread_t;

#ifdef _WIN64
typedef unsigned long long __graal_uword;
#else
typedef unsigned long __graal_uword;
#endif

/*
 * These constants can be used for the pkey field in the
 * graal_create_isolate_params_t struct to either specify that the isolate is
 * not part of a protection domain or a new protection domain should be
 * created for it.
 */
#define NO_PROTECTION_DOMAIN 0
#define NEW_PROTECTION_DOMAIN -1

/* Parameters for the creation of a new isolate. */
enum { __graal_create_isolate_params_version = 4 };
struct __graal_create_isolate_params_t {
    int version;                                /* Version of this struct */

    /* Fields introduced in version 1 */
    __graal_uword  reserved_address_space_size; /* Size of address space to reserve */

    /* Fields introduced in version 2 */
    const char    *auxiliary_image_path;                /* Path to an auxiliary image to load. */
    __graal_uword  auxiliary_image_reserved_space_size; /* Reserved bytes for loading an auxiliary image. */

    /* Fields introduced in version 3 */
    int            _reserved_1;                 /* Internal usage, do not use. */
    char         **_reserved_2;                 /* Internal usage, do not use. */
    int            pkey;                        /* Isolate protection key or domain. */

    /* Fields introduced in version 4 */
    char           _reserved_3;                 /* Internal usage, do not use. */
    char           _reserved_4;                 /* Internal usage, do not use. */
};
typedef struct __graal_create_isolate_params_t graal_create_isolate_params_t;

int BuiltinDirectives() {
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:char:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(char)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        char fieldHolder = all_bits_set;
        is_unsigned = fieldHolder > 0;
        printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:char:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:char_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(char*)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:double:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(double)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:float:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(float)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:graal_isolate_t_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(graal_isolate_t*)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:graal_isolatethread_t_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(graal_isolatethread_t*)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:int:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(int)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        int fieldHolder = all_bits_set;
        is_unsigned = fieldHolder > 0;
        printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:int:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:int_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(int*)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:long_long:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(long long)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        long long fieldHolder = all_bits_set;
        is_unsigned = fieldHolder > 0;
        printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:long_long:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:short:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(short)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        short fieldHolder = all_bits_set;
        is_unsigned = fieldHolder > 0;
        printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:short:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:struct_JNIEnv__:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(void *)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:struct_JavaVM__:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(void *)));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:void:PropertyInfo:size=%lu\n", ((unsigned long)1));
    printf("NativeCodeInfo:BuiltinDirectives:PointerToInfo:void_:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(void*)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(graal_create_isolate_params_t)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_1:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->_reserved_1)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_1:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, _reserved_1)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder._reserved_1 = all_bits_set;
        is_unsigned = fieldHolder._reserved_1 > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_1:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_2:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->_reserved_2)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_2:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, _reserved_2)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_3:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->_reserved_3)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_3:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, _reserved_3)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder._reserved_3 = all_bits_set;
        is_unsigned = fieldHolder._reserved_3 > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_3:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_4:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->_reserved_4)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_4:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, _reserved_4)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder._reserved_4 = all_bits_set;
        is_unsigned = fieldHolder._reserved_4 > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:_reserved_4:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:auxiliary_image_path:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->auxiliary_image_path)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:auxiliary_image_path:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, auxiliary_image_path)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:auxiliary_image_reserved_space_size:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->auxiliary_image_reserved_space_size)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:auxiliary_image_reserved_space_size:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, auxiliary_image_reserved_space_size)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.auxiliary_image_reserved_space_size = all_bits_set;
        is_unsigned = fieldHolder.auxiliary_image_reserved_space_size > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:auxiliary_image_reserved_space_size:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:pkey:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->pkey)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:pkey:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, pkey)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.pkey = all_bits_set;
        is_unsigned = fieldHolder.pkey > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:pkey:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:reserved_address_space_size:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->reserved_address_space_size)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:reserved_address_space_size:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, reserved_address_space_size)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.reserved_address_space_size = all_bits_set;
        is_unsigned = fieldHolder.reserved_address_space_size > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:reserved_address_space_size:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:version:PropertyInfo:size=%lu\n", ((unsigned long)sizeof(((graal_create_isolate_params_t *) 0)->version)));
    printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:version:PropertyInfo:offset=%lu\n", ((unsigned long)offsetof(graal_create_isolate_params_t, version)));
    {
        int is_unsigned;
        unsigned long all_bits_set = -1;
        graal_create_isolate_params_t fieldHolder;
        memset(&fieldHolder, 0x0, sizeof(fieldHolder));
        fieldHolder.version = all_bits_set;
        is_unsigned = fieldHolder.version > 0;
        printf("NativeCodeInfo:BuiltinDirectives:StructInfo:graal_create_isolate_params_t:StructFieldInfo:version:PropertyInfo:signedness=$%s$\n", (is_unsigned) ? "UNSIGNED" : "SIGNED");
    }
    return 0;
}

int main(void) {
    return BuiltinDirectives();
}
