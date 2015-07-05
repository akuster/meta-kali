gen_passwd () {
    #${STAGING_SBINDIR_NATIVE}/pwgen -1cn 8 1000000000 | dd obs=10M >  ${IMAGE_ROOTFS}/${datadir}/passwd.lst 
    ${STAGING_SBINDIR_NATIVE}/pwgen -1cn 8 1000000000  >  ${IMAGE_ROOTFS}/${datadir}/passwd.lst 

}

#EXTRA_IMAGEDEPENDS += "pwgen-native"

#ROOTFS_POSTPROCESS_COMMAND += 'gen_passwd;'
