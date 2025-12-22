inherit dpkg

PR = "0"

S = "${WORKDIR}/simdutf-${PV}"

SRC_URI = "https://github.com/simdutf/simdutf/archive/refs/tags/v${PV}.tar.gz;name=simdutf; \
    file://rules"
SRC_URI[simdutf.sha256sum] = "8fd729ebfd5ec56cb0395bcc176c4801e1f8a0ea834d166d52279d7b9e801283"

DEBIAN_PROVIDES = "simdutf, simdutf-dev"

DEBIAN_DEPENDS =. "\${shlibs:Depends}, \${misc:Depends},"

DEBIAN_BUILD_DEPENDS = " \
    cmake, \
    ninja-build"

do_prepare_build[cleandirs] += "${S}/debian"
do_prepare_build() {
    deb_debianize
}

