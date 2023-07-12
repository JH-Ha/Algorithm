class TreeNode
    attr_accessor :val, :children
    def initialize(val = 0)
        @val = val
        @children = []
    end
end

def dfs(checked, visited, cur)
    #puts "#{cur.val} #{visited}"
    if(visited[cur.val] && !checked[cur.val])
        return true
    end
    if(checked[cur.val])
        return false
    end 
    visited[cur.val] = true
    for i in 0..cur.children.length-1 do
        if(dfs(checked, visited, cur.children[i]))
            return true
        end
    end
    checked[cur.val] = true
    return false
end

def hasCycle(treeArr, num_courses, start)
    startNode = treeArr[start]
    queue = []
    visited = Array.new(num_courses, false)
    checked = Array.new(num_courses, false)
    return dfs(checked, visited, treeArr[start])
end
# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Boolean}
def can_finish(num_courses, prerequisites)
    treeArr = []
    for i in 0..num_courses do
        treeArr.append(TreeNode.new(i))
    end
    for i in 0..prerequisites.length-1 do
        prerequisite = prerequisites[i]
        treeArr[prerequisite[1]].children.append(treeArr[prerequisite[0]])
    end

    for i in 0..num_courses do
        if(hasCycle(treeArr, num_courses, i))
            puts "num #{i}"
            return false
        end
    end
    return true
end

puts ("#{can_finish(5, [[1,4],[2,4],[3,1],[3,2]])}")