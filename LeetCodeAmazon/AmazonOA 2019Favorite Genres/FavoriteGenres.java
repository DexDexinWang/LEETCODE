import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public Map<String, List<String>> FavoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
		Map<String, String> searchSongMap = new HashMap<>();
		for (Map.Entry<String, List<String>> entry: songGenres.entrySet()) {
			for (String song: entry.getValue()) {
				searchSongMap.put(song, entry.getKey());
			}
		}  //O(n)
		
		Map<String, List<String>> res = new HashMap<>();
		for(Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
			Map<String, Integer> counter = new HashMap<>();
			int maxSong = -1;
			for(String song: entry.getValue()) {
				if (searchSongMap.containsKey(song)) {
					int currentCount = counter.getOrDefault(searchSongMap.get(song), 0) + 1;
					counter.put(song, currentCount);
					maxSong = Math.max(maxSong, currentCount);
				}
			}
			
			List<String> partialRes = new LinkedList<>();
			for(Map.Entry<String, Integer> entry1: counter.entrySet()) {
				if (entry1.getValue() == maxSong) {
					partialRes.add(entry1.getKey());
				}
			}
			res.put(entry.getKey(), partialRes);
		}
		
		return res;
	}
	
	//Time Compelxity: O(n) + O(m) 
	//Space Complxity: O(n) + O(max(person`s favorite)).
}
