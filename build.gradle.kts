// This setting is purely for deployment to heroku. Omit it if you are not using heroku.
val stage by tasks.registering { dependsOn(":app:build") }
