package snippet;

public class Snippet {
	@RequestMapping(value="/updateUser", method =RequestMethod.PUT)
		public Map<String,Object> updateUser(@RequestBody UserDto userDto, @RequestParam(name="id", required=true)Long id ){
			
			Map<String,Object> result=new HashMap<>();
			result= userService.updateUser(userDto, id);
			return result;
			
			
		}
}

