class Solution {
    func convert(_ s: String, _ numRows: Int) -> String {
        if numRows == 1 { return s }
        if numRows >= s.count { return s }
        
        var rows: [[Character]] = []
        for i in 0 ..< numRows {
            rows.append([])
        }
        
        var currentRowIndex = 0
        var step = 1
        
        for char in s {
            rows[currentRowIndex].append(char)
            currentRowIndex += step
            
            if currentRowIndex == 0 || currentRowIndex == numRows - 1 {
                step = -step
            }
        }
        
        var result = ""
        for i in 0 ..< rows.count {
            let row = rows[i]
            result.append(.init(row))
        }
        
        return result
    }
}