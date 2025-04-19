impl Solution {
	pub fn count_fair_pairs(mut nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
		nums.sort_unstable();
		let mut ans = 0;
		for (i, &n) in (0..).zip(&nums) {
			let start = nums.partition_point(|&m| m < lower - n);
			let idx = nums[start..].partition_point(|&m| m <= upper - n);
			ans += idx as i64 - (start..start + idx).contains(&i) as i64;
		}
		ans / 2
	}
}