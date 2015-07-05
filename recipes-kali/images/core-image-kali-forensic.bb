require core-image-kali.bb

DESCRIPTION = "A Kali image with Forensic packages"

KALI_IMAGE_TYPE = "Kali-forensic"

IMAGE_INSTALL += "\
    packagegroup-kali-base \
    packagegroup-kali-forensic \
    "
