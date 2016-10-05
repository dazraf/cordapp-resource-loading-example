import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path
import java.nio.file.Paths

class Cordform extends DefaultTask {
    protected Path directory = Paths.get("./build/nodes")
    protected List<Node> nodes = new ArrayList<Node>()
    protected String networkMapNodeName

    public String directory(String directory) {
        this.directory = Paths.get(directory)
    }

    public String networkMap(String nodeName) {
        networkMapNodeName = nodeName
    }

    public void node(Closure configureClosure) {
        nodes << project.configure(new Node(project), configureClosure)
    }

    protected Node getNodeByName(String name) {
        for(Node node : nodes) {
            if(node.name.equals(networkMapNodeName)) {
                return node
            }
        }

        return null
    }

    @TaskAction
    def build() {
        nodes.each {
            Node networkMapNode = getNodeByName(networkMapNodeName)
            nodes.each {
                if(it != networkMapNode) {
                    it.networkMapAddress(networkMapNode.getArtemisAddress())
                }
                it.build(directory.toFile())
            }
        }
    }
}
