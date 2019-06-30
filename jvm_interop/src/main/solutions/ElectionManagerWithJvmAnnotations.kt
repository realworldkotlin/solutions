class ElectionManagerWithJvmAnnotations @JvmOverloads internal constructor(@JvmField val electionName: String = "USA 2008") {

    val legit: Boolean
        @JvmName("isLegit")
        get() = true

    companion object {

        const val copyright = "© 2018 VerySafe Election Systems. All rights reserved."

        @JvmStatic
        fun validateLicense(licence: String): Boolean {
            return "GqNCDvhNhKh2hrtJdHBXLqpq" == licence
        }
    }
}
