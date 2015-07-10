#!/usr/bin/env python

from distutils.core import setup
from distutils.extension import Extension
from Cython.Distutils import build_ext

import sys, os.path

PKG_NAME = 'capstone'

VERSION = '3.0.3'

# adapted from commit e504b81 of Nguyen Tan Cong
# Reference: https://docs.python.org/2/library/platform.html#cross-platform
is_64bits = sys.maxsize > 2**32
if __name__ == '__main__':

    setup(
        provides=['capstone'],
        packages=['capstone'],
        name=PKG_NAME,
        version=VERSION,
        author='Nguyen Anh Quynh',
        author_email='aquynh@gmail.com',
        description='Capstone disassembly engine',
        url='http://www.capstone-engine.org',
        classifiers=[
            'License :: OSI Approved :: BSD License',
            'Programming Language :: Python :: 2',
            'Programming Language :: Python :: 3',
        ],
        requires=['ctypes'],
        cmdclass={
            'build_ext': build_ext,
        },
    )
