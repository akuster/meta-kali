
PSWD_GEN_LEN ?= "8"
PSWD_GEN_NUM_PW ?= "100000"
PSWD_GEN_OPT ?= "-1cn"

gen_passwd () {
    ${STAGING_BINDIR_NATIVE}/pwgen ${PSWD_GEN_OPT} ${PSWD_GEN_LEN} ${PSWD_GEN_NUM_PW} >  ${IMAGE_ROOTFS}/${datadir}/passwd.lst 

}

EXTRA_IMAGEDEPENDS += " pwgen-native"

ROOTFS_POSTPROCESS_COMMAND_prepend = "gen_passwd;"
