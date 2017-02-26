#script to collect required stats on Team/Player information only
#created by: Mitch Stark 2/26/17

require 'rubygems'
require 'nokogiri'
require 'open-uri'


search = ['td.pla', 'td.age', 'td.starts', 'td.subIns', 'td.totalGoals', 'td.totalShots', 'td.shotsOnTarget', 'td.goalAssists', 'td.foulsCommitted', 'td.foulsSuffered', 'td.yellowCards', 'td.redCards']

site = ARGV[0]
page = Nokogiri::HTML(open(site))
columns = page.css('tbody')

players = columns.children

players.each do |player|
  if player.css('td.pla').text.strip != ''
    player_info = Hash.new
    search.each do |find|
      player_info[find] = player.css(find).text.strip
    end
    puts player_info
    #write player info to update_info.sql
  end
end
