#
# John has hard coded settings that are arch sepecific.
# this converts  TARGET_ARCH to linux-$
#

john_archs = "ia64 i386 x86 \
    ppc powerpc powerpc64 ppc64  \
    arm aarch64 mips"

def john_arch(a, d):
    import re

    valid_archs = d.getVar('john_archs', True).split()

    if   re.match('i.86', a):               return 'x86'
    elif re.match('x86.64$', a):            return 'x86'
    elif re.match('a(rm|rmeb)$', a):        return 'arm32'
    elif re.match('mips(el)$', a):          return 'mips'
    elif re.match('mips(64|64el)$', a):     return 'mips64'
    elif re.match('p(pc|owerpc)', a):       return 'ppc'
    elif re.match('p(pc64|owerpc64)', a):   return 'ppc64'
    elif a in valid_archs:                  return a
    else:
        bb.error("cannot map '%s' to a John architecture" % a)

export JOHN_ARCH = "${@john_arch(d.getVar('TARGET_ARCH', True), d)}"
