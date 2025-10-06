class Solution {
    func longestCommonPrefix(_ strs: [String]) -> String {
        guard var prefix = strs.first else {return ""}
        for i in strs.dropFirst() {
            while !i.hasPrefix(prefix) {
                prefix.removeLast()
                if prefix.isEmpty {return ""}
            }
        }
        return prefix
    }
}