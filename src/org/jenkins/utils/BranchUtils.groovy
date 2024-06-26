package org.jenkins.utils

class BranchUtils {
    static boolean isDevBranch(String branchName) {
        println "Checking if branch is Dev: ${branchName}"
        return branchName == 'develop'
    }

    static boolean isHmlBranch(String branchName) {
        println "Checking if branch is Hml: ${branchName}"
        return branchName == 'homolog'
    }

    static boolean isMasterBranch(String branchName) {
        println "Checking if branch is Master: ${branchName}"
        return branchName == 'main'
    }

    static boolean isValidBranch(String branchName) {
        println "Validating branch: ${branchName}"
        def isValid = isDevBranch(branchName) || isHmlBranch(branchName) || isMasterBranch(branchName)
        println "Is branch valid: ${isValid}"
        return isValid
    }

    static boolean isValidPullRequest(String sourceBranch, String targetBranch) {
        println "Validating branch sourceBranch: ${sourceBranch}"
        println "Validating branch targetBranch: ${targetBranch}"
        if (isDevBranch(sourceBranch) && isHmlBranch(targetBranch)) {
            return true
        } else if (isHmlBranch(sourceBranch) && isMasterBranch(targetBranch)) {
            return true
        } else {
            return false
        }
    }
}
