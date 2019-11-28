package com.raresociopath.jenkins.theme
/*
 * This script configures the simple theme plugin.
 * Requires the simple theme plugin to be installed.
 * Tested with simple-theme-plugin:0.5.1
 *
 * Use http://afonsof.com/jenkins-material-theme/ to generate a new jenkins theme.
 * Place the theme at the userContent directory of Jenkins to be publicly available
 */

import jenkins.model.Jenkins
import org.jenkinsci.plugins.simpletheme.CssUrlThemeElement

class ThemeConfigurator {

    def static themeDecorator = Jenkins.instance.getExtensionList(org.codefirst.SimpleThemeDecorator.class).first()

    static def configure() {
        themeDecorator.setElements([
            new CssUrlThemeElement('https://cdn.rawgit.com/afonsof/jenkins-material-theme/gh-pages/dist/material-blue.css')
        ])
        Jenkins.instance.save()
    }
}