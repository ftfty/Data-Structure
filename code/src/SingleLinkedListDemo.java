public class SingleLinkedListDemo{
    public static void main(String[] args){
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode);
        singleLinkedList.list();
    }
}
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"" ,"");
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("已存在");
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    public void updata(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("null");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
            if(flag){
                temp.name = newHeroNode.name;
            }else{
                System.out.println("null\n");
            }
        }
    }
    public void list(){
        if(head.next == null){
            System.out.println("null");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public  void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("wu");
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int hNo, String hName, String hNickname){
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
