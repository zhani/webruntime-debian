inherit dpkg

DESCRIPTION = "Weston Webruntime Modules"

SRC_URI = "git://git@github.com/KodeGood/weston-webruntime-modules.git;protocol=https;branch=main; \
            file://assets \
            file://rules"
SRCREV = "a666c7bb8fdc39bbb7ed1277589cb488c7f78e11"

S = "${WORKDIR}/git"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends}"
DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    libcairo2-dev, \
    pkgconf, \
    weston-dev"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build[cleandirs] += "${S}/assets"
do_prepare_build() {
    cp -r ${WORKDIR}/assets ${S}/
    deb_debianize
}
