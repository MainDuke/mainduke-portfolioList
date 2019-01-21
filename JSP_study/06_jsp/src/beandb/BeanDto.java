package beandb;
//DTO

public class BeanDto {
   //필드 
   private String id;
   private String name; 
   private String email;
   private String tel;
   private String content; 
   
   public BeanDto(){}//디폴트 생성자 
   //인자 있는 생성자 

   public BeanDto(String id, String name, String email, String tel,
         String content) {
      super();
      this.id = id;
      this.name = name;
      this.email = email;
      this.tel = tel;
      this.content = content;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }
   
}//class end 